/**
 */
package tll.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

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
	 * The cached value of the '{@link #getNeighbour() <em>Neighbour</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeighbour()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> neighbour;

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
	public EList<Component> getNeighbour() {
		if (neighbour == null) {
			neighbour = new EObjectResolvingEList<Component>(Component.class, this, TllPackage.TURNTABLE__NEIGHBOUR);
		}
		return neighbour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TllPackage.TURNTABLE__NEIGHBOUR:
				return getNeighbour();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TllPackage.TURNTABLE__NEIGHBOUR:
				getNeighbour().clear();
				getNeighbour().addAll((Collection<? extends Component>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TllPackage.TURNTABLE__NEIGHBOUR:
				getNeighbour().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TllPackage.TURNTABLE__NEIGHBOUR:
				return neighbour != null && !neighbour.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TurntableImpl
