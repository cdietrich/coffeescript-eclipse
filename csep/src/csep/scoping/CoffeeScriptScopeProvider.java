/*
 * generated by Xtext
 */
package csep.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class CoffeeScriptScopeProvider extends AbstractDeclarativeScopeProvider {

	@Override
	public IScope getScope(EObject context, EReference reference) {
		IScope parent = super.getScope(context, reference);
		return new DummyScope(parent);
	}
}
