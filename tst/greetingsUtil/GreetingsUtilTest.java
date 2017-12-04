package greetingsUtil;

import static org.junit.Assert.*;
import org.junit.*;

public class GreetingsUtilTest {
	static GreetingsUtil gu;	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gu = new GreetingsUtil();
	}

	@Before
	public void setUp() throws Exception {
		gu.ChangeState();
	}
	
	@Test
	public void testHello() {
		System.out.println("Hello");
		assertEquals(gu.currentState, "going");
		assertEquals(gu.Hello(),"Hi!");
		assertEquals(gu.currentState, "coming");
		assertEquals(gu.Hello(),"You already said that");
		assertEquals(gu.currentState, "coming");
	}

	@Test
	public void testGoodbye() {	
		System.out.println("Goodbye");
		assertEquals(gu.currentState, "coming");
		assertEquals(gu.GoodBye(),"bye");
		assertEquals(gu.currentState, "going");
		assertEquals(gu.GoodBye(),"You already said that");		
		assertEquals(gu.currentState, "going");
	}
	
	@After
	public void tearDown() throws Exception {	
		gu.ChangeState();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		gu = null;
	}
}
