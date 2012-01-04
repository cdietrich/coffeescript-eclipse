package csep.tests

import org.junit.Test

class ScopeTest extends ParserTestBase {
	
	@Test
	def void testBuiltIn() {
		okNoWarning('console.log 3')
		expect('missing.log 3', 0, 1)			
	}
	
	@Test
	def void testRequire() {
		okNoWarning('''
		  foo = require('./foo')
		  foo.bar()
		''')	
	}
	
  	@Test
  	def void testAssignment() {
      	okNoWarning('''
      	  a = 0
      	  b = a + 1
    	''')
    	okNoWarning('''
      	  a = 1
      	  a = 2
      	''')
  	}

	@Test
	def void testLambdaParameter() {
		okNoWarning('fun = (x) -> 2 * x')
		okNoWarning('''
		  fun = (x) ->
		    2 * x
		''')		
		expect('''
		  fun = (x) ->
		    2 * x
		  fun y
		''', 0, 1)
	}
	
	@Test
	def void testForLoopParameter() {
		okNoWarning('''
		  a = 0
		  for i in [1..10]
		    a += i
		''')
	}
}
