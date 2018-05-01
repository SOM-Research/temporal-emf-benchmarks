/**
 */
package tll.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import tll.Component;
import tll.Conveyor;
import tll.TllPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conveyor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tll.impl.ConveyorImpl#getNeighbour <em>Neighbour</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConveyorImpl extends ComponentImpl implements Conveyor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConveyorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TllPackage.Literals.CONVEYOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Component> getNeighbour() {
		return (EList<Component>)eGet(TllPackage.Literals.CONVEYOR__NEIGHBOUR, true);
	}

} //ConveyorImpl
