/**
 */
package tll.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import tll.Component;
import tll.Item;
import tll.LocationHistoryEntry;
import tll.TllPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tll.impl.ItemImpl#getStartLocation <em>Start Location</em>}</li>
 *   <li>{@link tll.impl.ItemImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link tll.impl.ItemImpl#isIsProcessed <em>Is Processed</em>}</li>
 *   <li>{@link tll.impl.ItemImpl#getHistory <em>History</em>}</li>
 *   <li>{@link tll.impl.ItemImpl#getHLocation <em>HLocation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItemImpl extends NamedElementImpl implements Item {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TllPackage.Literals.ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getStartLocation() {
		return (Component)eGet(TllPackage.Literals.ITEM__START_LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartLocation(Component newStartLocation) {
		eSet(TllPackage.Literals.ITEM__START_LOCATION, newStartLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getLocation() {
		return (Component)eGet(TllPackage.Literals.ITEM__LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(Component newLocation) {
		eSet(TllPackage.Literals.ITEM__LOCATION, newLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsProcessed() {
		return (Boolean)eGet(TllPackage.Literals.ITEM__IS_PROCESSED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsProcessed(boolean newIsProcessed) {
		eSet(TllPackage.Literals.ITEM__IS_PROCESSED, newIsProcessed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Component> getHistory() {
		return (EList<Component>)eGet(TllPackage.Literals.ITEM__HISTORY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<LocationHistoryEntry> getHLocation() {
		return (EList<LocationHistoryEntry>)eGet(TllPackage.Literals.ITEM__HLOCATION, true);
	}

} //ItemImpl
