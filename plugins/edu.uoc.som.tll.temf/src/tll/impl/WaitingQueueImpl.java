/**
 */
package tll.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import tll.Item;
import tll.TllPackage;
import tll.Turntable;
import tll.WaitingQueue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Waiting Queue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tll.impl.WaitingQueueImpl#getBufferedItems <em>Buffered Items</em>}</li>
 *   <li>{@link tll.impl.WaitingQueueImpl#getEntry <em>Entry</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WaitingQueueImpl extends ComponentImpl implements WaitingQueue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WaitingQueueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TllPackage.Literals.WAITING_QUEUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Item> getBufferedItems() {
		return (EList<Item>)eGet(TllPackage.Literals.WAITING_QUEUE__BUFFERED_ITEMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Turntable getEntry() {
		return (Turntable)eGet(TllPackage.Literals.WAITING_QUEUE__ENTRY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntry(Turntable newEntry) {
		eSet(TllPackage.Literals.WAITING_QUEUE__ENTRY, newEntry);
	}

} //WaitingQueueImpl
