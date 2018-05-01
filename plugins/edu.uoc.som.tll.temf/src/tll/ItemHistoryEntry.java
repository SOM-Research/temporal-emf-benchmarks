/**
 */
package tll;

import edu.uoc.som.temf.core.TObject;

import java.sql.Timestamp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item History Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tll.ItemHistoryEntry#getHValue <em>HValue</em>}</li>
 *   <li>{@link tll.ItemHistoryEntry#getBegin <em>Begin</em>}</li>
 *   <li>{@link tll.ItemHistoryEntry#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @see tll.TllPackage#getItemHistoryEntry()
 * @model
 * @extends TObject
 * @generated
 */
public interface ItemHistoryEntry extends TObject {
	/**
	 * Returns the value of the '<em><b>HValue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>HValue</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>HValue</em>' reference.
	 * @see #setHValue(Item)
	 * @see tll.TllPackage#getItemHistoryEntry_HValue()
	 * @model required="true"
	 * @generated
	 */
	Item getHValue();

	/**
	 * Sets the value of the '{@link tll.ItemHistoryEntry#getHValue <em>HValue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>HValue</em>' reference.
	 * @see #getHValue()
	 * @generated
	 */
	void setHValue(Item value);

	/**
	 * Returns the value of the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Begin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Begin</em>' attribute.
	 * @see #setBegin(Timestamp)
	 * @see tll.TllPackage#getItemHistoryEntry_Begin()
	 * @model dataType="tll.Timestamp" required="true"
	 * @generated
	 */
	Timestamp getBegin();

	/**
	 * Sets the value of the '{@link tll.ItemHistoryEntry#getBegin <em>Begin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Begin</em>' attribute.
	 * @see #getBegin()
	 * @generated
	 */
	void setBegin(Timestamp value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(Timestamp)
	 * @see tll.TllPackage#getItemHistoryEntry_End()
	 * @model dataType="tll.Timestamp" required="true"
	 * @generated
	 */
	Timestamp getEnd();

	/**
	 * Sets the value of the '{@link tll.ItemHistoryEntry#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Timestamp value);

} // ItemHistoryEntry
