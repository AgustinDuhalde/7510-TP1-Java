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
	public void juanShouldBeBoy() {
		Assert.assertTrue( knowledgeBase.answer("varon(juan)") );
	}

	@Test
	public void juanWithWhiteSpacesShouldBeBoy() {
		Assert.assertTrue( knowledgeBase.answer("varon ( juan )") );
	}

	@Test
	public void javierShouldNotBeBoy() {
		Assert.assertFalse( knowledgeBase.answer("varon (javier).") );
	}

	@Test
	public void juanShouldBePepesFather() {
		Assert.assertTrue( knowledgeBase.answer( "hijo(pepe,juan)") );
	}

	@Test
	public void pepeShouldNotBeJuansFather() {
		Assert.assertFalse( knowledgeBase.answer( "hijo(juan,pepe)") );
	}

	@Test
	public void nicolasShouldBeBoy() {
		Assert.assertTrue( knowledgeBase.answer( "varon(nicolas)") );
	}

	@Test
	public void nicolasShouldBeRobertosBrother() {
		Assert.assertTrue( knowledgeBase.answer( "hermano(nicolas, roberto)"));
	}

	@Test
	public void nicolasShouldBeAlejandrosUncle() {
		Assert.assertTrue( knowledgeBase.answer( "tio(nicolas,alejandro,roberto)"));
	}
}
