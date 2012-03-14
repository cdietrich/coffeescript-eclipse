/*
 * generated by Xtext
 */
package csep.example.cake.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import com.google.inject.Inject;

import csep.coffeeScript.Block;
import csep.example.cake.cakefile.TaskDeclaration;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class CakefileScopeProvider extends AbstractDeclarativeScopeProvider implements IScopeProviderWithNode {
	@Inject 
	private LinkingHelper linkingHelper;
	
	INode node;
	
	public IScope scope_Id(TaskDeclaration owner, EReference ref) {
		String crossrefName = linkingHelper.getCrossRefNodeAsString(node, true);
		if ("options".equals(crossrefName)) {
			// TODO: create a scope with it
			return IScope.NULLSCOPE;
		}
		else {
			// Let superclass handle it
			return null;
		}
	}

	@Override
	public void setNode(INode node) {
		this.node = node;		
	}
}
