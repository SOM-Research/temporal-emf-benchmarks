/**
 */
package tll.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tll.SimConfig;
import tll.TllPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sim Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tll.impl.SimConfigImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link tll.impl.SimConfigImpl#getIterations <em>Iterations</em>}</li>
 *   <li>{@link tll.impl.SimConfigImpl#isEnableLogging <em>Enable Logging</em>}</li>
 *   <li>{@link tll.impl.SimConfigImpl#isRecordHistory <em>Record History</em>}</li>
 *   <li>{@link tll.impl.SimConfigImpl#isStoreProcessedItems <em>Store Processed Items</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimConfigImpl extends MinimalEObjectImpl.Container implements SimConfig {
	/**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final int TIMEOUT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected int timeout = TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIterations() <em>Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations()
	 * @generated
	 * @ordered
	 */
	protected static final int ITERATIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIterations() <em>Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterations()
	 * @generated
	 * @ordered
	 */
	protected int iterations = ITERATIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnableLogging() <em>Enable Logging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnableLogging()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLE_LOGGING_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnableLogging() <em>Enable Logging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnableLogging()
	 * @generated
	 * @ordered
	 */
	protected boolean enableLogging = ENABLE_LOGGING_EDEFAULT;

	/**
	 * The default value of the '{@link #isRecordHistory() <em>Record History</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRecordHistory()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RECORD_HISTORY_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRecordHistory() <em>Record History</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRecordHistory()
	 * @generated
	 * @ordered
	 */
	protected boolean recordHistory = RECORD_HISTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #isStoreProcessedItems() <em>Store Processed Items</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStoreProcessedItems()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STORE_PROCESSED_ITEMS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isStoreProcessedItems() <em>Store Processed Items</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStoreProcessedItems()
	 * @generated
	 * @ordered
	 */
	protected boolean storeProcessedItems = STORE_PROCESSED_ITEMS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TllPackage.Literals.SIM_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeout(int newTimeout) {
		int oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TllPackage.SIM_CONFIG__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIterations() {
		return iterations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterations(int newIterations) {
		int oldIterations = iterations;
		iterations = newIterations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TllPackage.SIM_CONFIG__ITERATIONS, oldIterations, iterations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnableLogging() {
		return enableLogging;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableLogging(boolean newEnableLogging) {
		boolean oldEnableLogging = enableLogging;
		enableLogging = newEnableLogging;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TllPackage.SIM_CONFIG__ENABLE_LOGGING, oldEnableLogging, enableLogging));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRecordHistory() {
		return recordHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordHistory(boolean newRecordHistory) {
		boolean oldRecordHistory = recordHistory;
		recordHistory = newRecordHistory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TllPackage.SIM_CONFIG__RECORD_HISTORY, oldRecordHistory, recordHistory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStoreProcessedItems() {
		return storeProcessedItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoreProcessedItems(boolean newStoreProcessedItems) {
		boolean oldStoreProcessedItems = storeProcessedItems;
		storeProcessedItems = newStoreProcessedItems;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TllPackage.SIM_CONFIG__STORE_PROCESSED_ITEMS, oldStoreProcessedItems, storeProcessedItems));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TllPackage.SIM_CONFIG__TIMEOUT:
				return getTimeout();
			case TllPackage.SIM_CONFIG__ITERATIONS:
				return getIterations();
			case TllPackage.SIM_CONFIG__ENABLE_LOGGING:
				return isEnableLogging();
			case TllPackage.SIM_CONFIG__RECORD_HISTORY:
				return isRecordHistory();
			case TllPackage.SIM_CONFIG__STORE_PROCESSED_ITEMS:
				return isStoreProcessedItems();
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
			case TllPackage.SIM_CONFIG__TIMEOUT:
				setTimeout((Integer)newValue);
				return;
			case TllPackage.SIM_CONFIG__ITERATIONS:
				setIterations((Integer)newValue);
				return;
			case TllPackage.SIM_CONFIG__ENABLE_LOGGING:
				setEnableLogging((Boolean)newValue);
				return;
			case TllPackage.SIM_CONFIG__RECORD_HISTORY:
				setRecordHistory((Boolean)newValue);
				return;
			case TllPackage.SIM_CONFIG__STORE_PROCESSED_ITEMS:
				setStoreProcessedItems((Boolean)newValue);
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
			case TllPackage.SIM_CONFIG__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case TllPackage.SIM_CONFIG__ITERATIONS:
				setIterations(ITERATIONS_EDEFAULT);
				return;
			case TllPackage.SIM_CONFIG__ENABLE_LOGGING:
				setEnableLogging(ENABLE_LOGGING_EDEFAULT);
				return;
			case TllPackage.SIM_CONFIG__RECORD_HISTORY:
				setRecordHistory(RECORD_HISTORY_EDEFAULT);
				return;
			case TllPackage.SIM_CONFIG__STORE_PROCESSED_ITEMS:
				setStoreProcessedItems(STORE_PROCESSED_ITEMS_EDEFAULT);
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
			case TllPackage.SIM_CONFIG__TIMEOUT:
				return timeout != TIMEOUT_EDEFAULT;
			case TllPackage.SIM_CONFIG__ITERATIONS:
				return iterations != ITERATIONS_EDEFAULT;
			case TllPackage.SIM_CONFIG__ENABLE_LOGGING:
				return enableLogging != ENABLE_LOGGING_EDEFAULT;
			case TllPackage.SIM_CONFIG__RECORD_HISTORY:
				return recordHistory != RECORD_HISTORY_EDEFAULT;
			case TllPackage.SIM_CONFIG__STORE_PROCESSED_ITEMS:
				return storeProcessedItems != STORE_PROCESSED_ITEMS_EDEFAULT;
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
		result.append(" (timeout: ");
		result.append(timeout);
		result.append(", iterations: ");
		result.append(iterations);
		result.append(", enableLogging: ");
		result.append(enableLogging);
		result.append(", recordHistory: ");
		result.append(recordHistory);
		result.append(", storeProcessedItems: ");
		result.append(storeProcessedItems);
		result.append(')');
		return result.toString();
	}

} //SimConfigImpl
