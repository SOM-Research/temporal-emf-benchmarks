/**
 */
package tll;

import edu.uoc.som.temf.core.TObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sim Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tll.SimConfig#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link tll.SimConfig#getIterations <em>Iterations</em>}</li>
 *   <li>{@link tll.SimConfig#isEnableLogging <em>Enable Logging</em>}</li>
 *   <li>{@link tll.SimConfig#isRecordHistory <em>Record History</em>}</li>
 *   <li>{@link tll.SimConfig#isStoreProcessedItems <em>Store Processed Items</em>}</li>
 * </ul>
 *
 * @see tll.TllPackage#getSimConfig()
 * @model
 * @extends TObject
 * @generated
 */
public interface SimConfig extends TObject {
	/**
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(int)
	 * @see tll.TllPackage#getSimConfig_Timeout()
	 * @model
	 * @generated
	 */
	int getTimeout();

	/**
	 * Sets the value of the '{@link tll.SimConfig#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
	void setTimeout(int value);

	/**
	 * Returns the value of the '<em><b>Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterations</em>' attribute.
	 * @see #setIterations(int)
	 * @see tll.TllPackage#getSimConfig_Iterations()
	 * @model
	 * @generated
	 */
	int getIterations();

	/**
	 * Sets the value of the '{@link tll.SimConfig#getIterations <em>Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterations</em>' attribute.
	 * @see #getIterations()
	 * @generated
	 */
	void setIterations(int value);

	/**
	 * Returns the value of the '<em><b>Enable Logging</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Logging</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Logging</em>' attribute.
	 * @see #setEnableLogging(boolean)
	 * @see tll.TllPackage#getSimConfig_EnableLogging()
	 * @model default="true"
	 * @generated
	 */
	boolean isEnableLogging();

	/**
	 * Sets the value of the '{@link tll.SimConfig#isEnableLogging <em>Enable Logging</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Logging</em>' attribute.
	 * @see #isEnableLogging()
	 * @generated
	 */
	void setEnableLogging(boolean value);

	/**
	 * Returns the value of the '<em><b>Record History</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Record History</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Record History</em>' attribute.
	 * @see #setRecordHistory(boolean)
	 * @see tll.TllPackage#getSimConfig_RecordHistory()
	 * @model default="true"
	 * @generated
	 */
	boolean isRecordHistory();

	/**
	 * Sets the value of the '{@link tll.SimConfig#isRecordHistory <em>Record History</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record History</em>' attribute.
	 * @see #isRecordHistory()
	 * @generated
	 */
	void setRecordHistory(boolean value);

	/**
	 * Returns the value of the '<em><b>Store Processed Items</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store Processed Items</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store Processed Items</em>' attribute.
	 * @see #setStoreProcessedItems(boolean)
	 * @see tll.TllPackage#getSimConfig_StoreProcessedItems()
	 * @model default="true"
	 * @generated
	 */
	boolean isStoreProcessedItems();

	/**
	 * Sets the value of the '{@link tll.SimConfig#isStoreProcessedItems <em>Store Processed Items</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store Processed Items</em>' attribute.
	 * @see #isStoreProcessedItems()
	 * @generated
	 */
	void setStoreProcessedItems(boolean value);

} // SimConfig
