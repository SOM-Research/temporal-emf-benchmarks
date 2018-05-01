/**
 */
package tll.impl;

import edu.uoc.som.temf.core.impl.TObjectImpl;

import org.eclipse.emf.ecore.EClass;

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
public class SimConfigImpl extends TObjectImpl implements SimConfig {
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
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimeout() {
		return (Integer)eGet(TllPackage.Literals.SIM_CONFIG__TIMEOUT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeout(int newTimeout) {
		eSet(TllPackage.Literals.SIM_CONFIG__TIMEOUT, newTimeout);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIterations() {
		return (Integer)eGet(TllPackage.Literals.SIM_CONFIG__ITERATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterations(int newIterations) {
		eSet(TllPackage.Literals.SIM_CONFIG__ITERATIONS, newIterations);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnableLogging() {
		return (Boolean)eGet(TllPackage.Literals.SIM_CONFIG__ENABLE_LOGGING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableLogging(boolean newEnableLogging) {
		eSet(TllPackage.Literals.SIM_CONFIG__ENABLE_LOGGING, newEnableLogging);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRecordHistory() {
		return (Boolean)eGet(TllPackage.Literals.SIM_CONFIG__RECORD_HISTORY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordHistory(boolean newRecordHistory) {
		eSet(TllPackage.Literals.SIM_CONFIG__RECORD_HISTORY, newRecordHistory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStoreProcessedItems() {
		return (Boolean)eGet(TllPackage.Literals.SIM_CONFIG__STORE_PROCESSED_ITEMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoreProcessedItems(boolean newStoreProcessedItems) {
		eSet(TllPackage.Literals.SIM_CONFIG__STORE_PROCESSED_ITEMS, newStoreProcessedItems);
	}

} //SimConfigImpl
