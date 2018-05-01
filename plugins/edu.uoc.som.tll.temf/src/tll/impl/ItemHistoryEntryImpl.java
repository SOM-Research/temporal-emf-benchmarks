/**
 */
package tll.impl;

import edu.uoc.som.temf.core.impl.TObjectImpl;

import java.sql.Timestamp;

import org.eclipse.emf.ecore.EClass;

import tll.Item;
import tll.ItemHistoryEntry;
import tll.TllPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item History Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tll.impl.ItemHistoryEntryImpl#getHValue <em>HValue</em>}</li>
 *   <li>{@link tll.impl.ItemHistoryEntryImpl#getBegin <em>Begin</em>}</li>
 *   <li>{@link tll.impl.ItemHistoryEntryImpl#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItemHistoryEntryImpl extends TObjectImpl implements ItemHistoryEntry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ItemHistoryEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TllPackage.Literals.ITEM_HISTORY_ENTRY;
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
	public Item getHValue() {
		return (Item)eGet(TllPackage.Literals.ITEM_HISTORY_ENTRY__HVALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHValue(Item newHValue) {
		eSet(TllPackage.Literals.ITEM_HISTORY_ENTRY__HVALUE, newHValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timestamp getBegin() {
		return (Timestamp)eGet(TllPackage.Literals.ITEM_HISTORY_ENTRY__BEGIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBegin(Timestamp newBegin) {
		eSet(TllPackage.Literals.ITEM_HISTORY_ENTRY__BEGIN, newBegin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Timestamp getEnd() {
		return (Timestamp)eGet(TllPackage.Literals.ITEM_HISTORY_ENTRY__END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(Timestamp newEnd) {
		eSet(TllPackage.Literals.ITEM_HISTORY_ENTRY__END, newEnd);
	}

} //ItemHistoryEntryImpl
