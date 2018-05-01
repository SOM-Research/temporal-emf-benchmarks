/**
 */
package tll.impl;

import edu.uoc.som.temf.core.impl.TObjectImpl;

import java.sql.Timestamp;

import org.eclipse.emf.ecore.EClass;

import tll.Component;
import tll.LocationHistoryEntry;
import tll.TllPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Location History Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tll.impl.LocationHistoryEntryImpl#getHValue <em>HValue</em>}</li>
 *   <li>{@link tll.impl.LocationHistoryEntryImpl#getBegin <em>Begin</em>}</li>
 *   <li>{@link tll.impl.LocationHistoryEntryImpl#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LocationHistoryEntryImpl extends TObjectImpl implements LocationHistoryEntry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocationHistoryEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TllPackage.Literals.LOCATION_HISTORY_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getHValue() {
		return (Component)eGet(TllPackage.Literals.LOCATION_HISTORY_ENTRY__HVALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHValue(Component newHValue) {
		eSet(TllPackage.Literals.LOCATION_HISTORY_ENTRY__HVALUE, newHValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timestamp getBegin() {
		return (Timestamp)eGet(TllPackage.Literals.LOCATION_HISTORY_ENTRY__BEGIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBegin(Timestamp newBegin) {
		eSet(TllPackage.Literals.LOCATION_HISTORY_ENTRY__BEGIN, newBegin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timestamp getEnd() {
		return (Timestamp)eGet(TllPackage.Literals.LOCATION_HISTORY_ENTRY__END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(Timestamp newEnd) {
		eSet(TllPackage.Literals.LOCATION_HISTORY_ENTRY__END, newEnd);
	}

} //LocationHistoryEntryImpl
