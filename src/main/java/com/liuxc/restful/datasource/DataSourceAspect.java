package com.liuxc.restful.datasource;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author L
 *
 */
@Aspect
@Component
@Order(1)
public class DataSourceAspect {

	private static final Logger LOGGER = Logger.getLogger(DataSourceAspect.class);

	public DataSourceAspect() {
		System.out.println("数据源AOP切面初始化！");
	}

	@Before("execution(* com.liuxc.restful.service.**.*(..))")
	public void before(JoinPoint point) throws NoSuchMethodException, SecurityException {
		
		  Class<?> className = point.getTarget().getClass(); 
		  String targetDataSource = null;
		  DataSourceAnnotation typeAnnotation = className.getAnnotation(DataSourceAnnotation.class);
		  if (typeAnnotation != null) { 
			  targetDataSource = typeAnnotation.value().name(); 
			}
		  Signature signature = point.getSignature(); 
		  try { 
			  Method method = className.getMethod(signature.getName(), ((MethodSignature) signature).getParameterTypes()); 
			  DataSourceAnnotation methodAnnotation = method.getAnnotation(DataSourceAnnotation.class);
		     if (methodAnnotation != null) { 
			     targetDataSource =  methodAnnotation.value().name(); 
			    }
		  
		  if (StringUtils.isNotBlank(targetDataSource)) {
		       DataSourceContextHolder.setDataSource(targetDataSource); 
		       LOGGER.info( "数据源切换为 ========> " + targetDataSource); 
		       } 
		 } catch (Exception e) {
		  LOGGER.error(e);
		  }
		 
		
		/** 切DAO接口 **/
		/*Object target = point.getTarget();
		String method = point.getSignature().getName();
		Class<?>[] clazz = target.getClass().getInterfaces();
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
		String dataSourceName = null;
		try {
			DataSourceAnnotation annotation = clazz[0].getAnnotation(DataSourceAnnotation.class);
			if (annotation != null) {
				dataSourceName = annotation.value().name();
			}
			
			Method m = clazz[0].getMethod(method, parameterTypes);
			// 如果方法上存在切换数据源的注解，则根据注解内容进行数据源切换
			if (m != null && m.isAnnotationPresent(DataSourceAnnotation.class)) {
				DataSourceAnnotation data = m.getAnnotation(DataSourceAnnotation.class);
				dataSourceName = data.value().name();
				LOGGER.debug("current thread " + Thread.currentThread().getName() + " add " + dataSourceName+ " to ThreadLocal");
			} else {
				LOGGER.debug("switch datasource fail,use default");
			}
			
			if(StringUtils.isNotBlank(dataSourceName)){
				
				DataSourceContextHolder.setDataSource(dataSourceName);
				LOGGER.info( "数据源切换为 ========> " + dataSourceName);
			}
			
		} catch (Exception e) {
			LOGGER.error("current thread " + Thread.currentThread().getName() + " add data to ThreadLocal error", e);
		}*/

	}

	@After("execution(* com.liuxc.restful.service.**.*(..))")
	public void after(JoinPoint point) {
		if (DataSourceContextHolder.getDataSource() != null) {
			DataSourceContextHolder.clearDataSource();
			LOGGER.info("<======== 清除数据源 ========> ");
		}
	}
}