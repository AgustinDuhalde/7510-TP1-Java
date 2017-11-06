package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KnowledgeBaseTest {

	private KnowledgeBase knowledgeBase;

	@Before
	public void setUp() {
		knowledgeBase = new KnowledgeBase( "rules.db" );
	}

	@Test
	public void test() {

		Assert.assertTrue(this.knowledgeBase.answer("varon (javier)."));

	}

}
