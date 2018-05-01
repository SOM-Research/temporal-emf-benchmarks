/**
 */
package tll.impl;

import java.sql.Timestamp;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

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
public class LocationHistoryEntryImpl extends MinimalEObjectImpl.Container implements LocationHistoryEntry {
	/**
	 * The cached value of the '{@link #getHValue() <em>HValue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHValue()
	 * @generated
	 * @ordered
	 */
	protected Component hValue;

	/**
	 * The default value of the '{@link #getBegin() <em>Begin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBegin()
	 * @generated
	 * @ordered
	 */
	protected static final Timestamp BEGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBegin() <em>Begin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBegin()
	 * @generated
	 * @ordered
	 */
	protected Timestamp begin = BEGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected static final Timestamp END_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected Timestamp end = END_EDEFAULT;

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
	public Component getHValue() {
		if (hValue != null && hValue.eIsProxy()) {
			InternalEObject oldHValue = (InternalEObject)hValue;
			hValue = (Component)eResolveProxy(oldHValue);
			if (hValue != oldHValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TllPackage.LOCATION_HISTORY_ENTRY__HVALUE, oldHValue, hValue));
			}
		}
		return hValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetHValue() {
		return hValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHValue(Component newHValue) {
		Component oldHValue = hValue;
		hValue = newHValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TllPackage.LOCATION_HISTORY_ENTRY__HVALUE, oldHValue, hValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timestamp getBegin() {
		return begin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBegin(Timestamp newBegin) {
		Timestamp oldBegin = begin;
		begin = newBegin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TllPackage.LOCATION_HISTORY_ENTRY__BEGIN, oldBegin, begin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timestamp getEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(Timestamp newEnd) {
		Timestamp oldEnd = end;
		end = newEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TllPackage.LOCATION_HISTORY_ENTRY__END, oldEnd, end));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TllPackage.LOCATION_HISTORY_ENTRY__HVALUE:
				if (resolve) return getHValue();
				return basicGetHValue();
			case TllPackage.LOCATION_HISTORY_ENTRY__BEGIN:
				return getBegin();
			case TllPackage.LOCATION_HISTORY_ENTRY__END:
				return getEnd();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TllPackage.LOCATION_HISTORY_ENTRY__HVALUE:
				setHValue((Component)newValue);
				return;
			case TllPackage.LOCATION_HISTORY_ENTRY__BEGIN:
				setBegin((Timestamp)newValue);
				return;
			case TllPackage.LOCATION_HISTORY_ENTRY__END:
				setEnd((Timestamp)newValue);
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
			case TllPackage.LOCATION_HISTORY_ENTRY__HVALUE:
				setHValue((Component)null);
				return;
			case TllPackage.LOCATION_HISTORY_ENTRY__BEGIN:
				setBegin(BEGIN_EDEFAULT);
				return;
			case TllPackage.LOCATION_HISTORY_ENTRY__END:
				setEnd(END_EDEFAULT);
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
			case TllPackage.LOCATION_HISTORY_ENTRY__HVALUE:
				return hValue != null;
			case TllPackage.LOCATION_HISTORY_ENTRY__BEGIN:
				return BEGIN_EDEFAULT == null ? begin != null : !BEGIN_EDEFAULT.equals(begin);
			case TllPackage.LOCATION_HISTORY_ENTRY__END:
				return END_EDEFAULT == null ? end != null : !END_EDEFAULT.equals(end);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (begin: ");
		result.append(begin);
		result.append(", end: ");
		result.append(end);
		result.append(')');
		return result.toString();
	}

} //LocationHistoryEntryImpl
