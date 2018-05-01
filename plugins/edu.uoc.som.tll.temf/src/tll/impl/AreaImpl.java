/**
 */
package tll.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import tll.Area;
import tll.Component;
import tll.Item;
import tll.ItemGenerator;
import tll.StorageQueue;
import tll.TllPackage;
import tll.WaitingQueue;

import tll.time.TimeWatch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tll.impl.AreaImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link tll.impl.AreaImpl#getItemGen <em>Item Gen</em>}</li>
 *   <li>{@link tll.impl.AreaImpl#getStore <em>Store</em>}</li>
 *   <li>{@link tll.impl.AreaImpl#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link tll.impl.AreaImpl#getItem <em>Item</em>}</li>
 *   <li>{@link tll.impl.AreaImpl#getLog <em>Log</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AreaImpl extends NamedElementImpl implements Area {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AreaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TllPackage.Literals.AREA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Component> getComponent() {
		return (EList<Component>)eGet(TllPackage.Literals.AREA__COMPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemGenerator getItemGen() {
		return (ItemGenerator)eGet(TllPackage.Literals.AREA__ITEM_GEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemGen(ItemGenerator newItemGen) {
		eSet(TllPackage.Literals.AREA__ITEM_GEN, newItemGen);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorageQueue getStore() {
		return (StorageQueue)eGet(TllPackage.Literals.AREA__STORE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStore(StorageQueue newStore) {
		eSet(TllPackage.Literals.AREA__STORE, newStore);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaitingQueue getBuffer() {
		return (WaitingQueue)eGet(TllPackage.Literals.AREA__BUFFER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuffer(WaitingQueue newBuffer) {
		eSet(TllPackage.Literals.AREA__BUFFER, newBuffer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Item> getItem() {
		return (EList<Item>)eGet(TllPackage.Literals.AREA__ITEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getLog() {
		return (EList<String>)eGet(TllPackage.Literals.AREA__LOG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void start() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void itemGen(TimeWatch watch) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TllPackage.AREA___START:
				start();
				return null;
			case TllPackage.AREA___ITEM_GEN__TIMEWATCH:
				itemGen((TimeWatch)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //AreaImpl
