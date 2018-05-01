/**
 */
package tll.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import tll.Component;
import tll.TllPackage;
import tll.Turntable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Turntable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tll.impl.TurntableImpl#getNeighbour <em>Neighbour</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TurntableImpl extends ComponentImpl implements Turntable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TurntableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TllPackage.Literals.TURNTABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Component> getNeighbour() {
		return (EList<Component>)eGet(TllPackage.Literals.TURNTABLE__NEIGHBOUR, true);
	}

} //TurntableImpl
