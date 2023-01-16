package az.developia.springrest.aop;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import az.developia.springrest.model.DataWrapper;
import az.developia.springrest.model.Student;

@Aspect
@Component
@Order(value = 1)
public class MyAspect {




@Around(value = "execution(  * az.developia.springrest.service.*.findAll*(..))")
public Object doIt6(ProceedingJoinPoint pjp) {

	Object proceed=null;
	try {
		proceed=pjp.proceed(); //pjp.proceed ne qaytarir?
	}catch(Throwable e) {//bunu sorus
		System.out.println(e.getMessage());
	}
	DataWrapper dw=	(DataWrapper) proceed;//proceed book tipinnnen olsaydi list<student>-e cast elemek olardi?




	System.out.println("::::"+dw.getAge());
	System.out.println("::::"+dw.getStudents());
for (Student s : dw.getStudents()) {
	s.setName("Adil12");
}
	return dw;
}


@Before(value = "execution(  * az.developia.springrest.service.*.save*(..))")
public void doIt2(JoinPoint jp) {
	System.out.println("mudure mail at");
MethodSignature ms=	(MethodSignature) jp.getSignature();
System.out.println(":::"+ms);
Object[] args = jp.getArgs();
for (Object a : args) {
	System.out.println(a);
}
}
}
