package com.syc.persistence.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/persistence-app-ctx.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback = false)
@Transactional
public abstract class BaseTest extends AbstractTransactionalJUnit4SpringContextTests{
}
