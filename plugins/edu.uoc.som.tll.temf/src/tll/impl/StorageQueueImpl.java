/**
 */
package tll.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import tll.Item;
import tll.StorageQueue;
import tll.TllPackage;
import tll.Turntable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Storage Queue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tll.impl.StorageQueueImpl#getFinalItems <em>Final Items</em>}</li>
 *   <li>{@link tll.impl.StorageQueueImpl#getExit <em>Exit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StorageQueueImpl extends ComponentImpl implements StorageQueue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StorageQueueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TllPackage.Literals.STORAGE_QUEUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Item> getFinalItems() {
		return (EList<Item>)eGet(TllPackage.Literals.STORAGE_QUEUE__FINAL_ITEMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Turntable getExit() {
		return (Turntable)eGet(TllPackage.Literals.STORAGE_QUEUE__EXIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExit(Turntable newExit) {
		eSet(TllPackage.Literals.STORAGE_QUEUE__EXIT, newExit);
	}

} //StorageQueueImpl
