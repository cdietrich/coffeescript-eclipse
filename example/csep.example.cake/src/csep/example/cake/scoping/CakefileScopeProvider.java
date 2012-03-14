/*
 * generated by Xtext
 */
package csep.example.cake.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SingletonScope;

import com.google.inject.Inject;

import csep.coffeeScript.Block;
import csep.coffeeScript.CoffeeScriptFactory;
import csep.coffeeScript.Id;
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
	Id options;
	
	public CakefileScopeProvider() {
		super();
		options = CoffeeScriptFactory.eINSTANCE.createId();
		options.setName("options");
	}
	
	public IScope scope_Id(TaskDeclaration owner, EReference ref) {
		String crossrefName = linkingHelper.getCrossRefNodeAsString(node, true);
		if ("options".equals(crossrefName)) {
			IEObjectDescription description = EObjectDescription.create(options.getName(), options);
			return new SingletonScope(description, IScope.NULLSCOPE);
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
