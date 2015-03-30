package br.org.base.interceptor;

import br.org.base.data.Crud;
import br.org.base.model.Member;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@Interceptor
@Audit
public class MemberAudit {
	
	//@Inject
	//private Crud<Member> crud;
	
    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        System.out.println("SimpleInterceptor - Logging BEFORE calling method :"+context.getMethod().getName() );
        
        String out = "";
        String format = "";
        Member param = null;

        Audit audit2 = context.getMethod().getAnnotation(Audit.class);
        String message = audit2.message();
        format = message;
        System.out.println(message);
        
        Collection col = Arrays.asList( context.getParameters());
        Iterator<Member> memberIterator = col.iterator();
        while(memberIterator.hasNext()){
            Member member = memberIterator.next();
            param = member;
            System.out.println(member.getName());
        }
        
        if(format != ""){
            System.out.println(String.format("Member cnanged %s ", param.toString()));
        }else {
            System.out.println(String.format("%s cnanged %s ", param.getClass().getName(), param.toString()));
        }


        
        Object result = context.proceed();

        System.out.println("SimpleInterceptor - Logging AFTER calling method :"+context.getMethod().getName() );

        return result;
    }
}
