/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.org.base.test;

import br.org.base.data.Crud;
import br.org.base.data.MemberRepository;
import br.org.base.model.Invoice;
import br.org.base.model.Member;
import br.org.base.model.Periodicity;
import br.org.base.model.Venda;
import br.org.base.service.MemberRegistration;
import br.org.base.service.VendaService;
import br.org.base.util.Resources;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.List;
import java.util.logging.Logger;

import junit.framework.Assert;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class MemberRegistrationTest {
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(
                		Member.class, 
                		Invoice.class,
                		Periodicity.class,
                		Crud.class, 
                		Venda.class,
                		MemberRegistration.class,
                		MemberRepository.class, 
                		VendaService.class,
                		Resources.class 
                		
                		
                		
                		)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml", "test-ds.xml");
    }

    @Inject
    MemberRegistration memberRegistration;
    @Inject
    MemberRepository memberRepository;
    @Inject
    VendaService venda;

    @Inject
    Logger log;

    @Test
    public void testRegister() throws Exception {
        Member newMember = new Member();
        newMember.setName("Jane Doe");
        newMember.setEmail("jane@mailinator.com");
        newMember.setPhoneNumber("2125551234");
        memberRegistration.register(newMember);
        assertNotNull(newMember.getId());
        log.info(newMember.getName() + " was persisted with id " + newMember.getId());
        
    }
    
    @Test
    public void testSqlMapping() {
    	Venda v = new Venda();
    	//v.setId(1L);
    	v.setNome("asdasda");
    	v.setPessoa("pessoa");
 
    	v.setValor(3.5f);
    	venda.insere(v);
    	
        List<Venda> lst = venda.list();
        Assert.assertFalse(lst.size() == 0);
        
    }
    
    @Test
    public void test(){
        List<Member> memberList = memberRepository.findAllOrderedByName();
        System.out.println(memberList);
        
    }

}
