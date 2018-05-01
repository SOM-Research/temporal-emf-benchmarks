/**
 */
package tll.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import tll.Component;
import tll.Item;
import tll.ItemHistoryEntry;
import tll.TllPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tll.impl.ComponentImpl#getHosts <em>Hosts</em>}</li>
 *   <li>{@link tll.impl.ComponentImpl#getProcessingTime <em>Processing Time</em>}</li>
 *   <li>{@link tll.impl.ComponentImpl#getUncertainty <em>Uncertainty</em>}</li>
 *   <li>{@link tll.impl.ComponentImpl#getHHosts <em>HHosts</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ComponentImpl extends NamedElementImpl implements Component {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TllPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Item getHosts() {
		return (Item)eGet(TllPackage.Literals.COMPONENT__HOSTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHosts(Item newHosts) {
		eSet(TllPackage.Literals.COMPONENT__HOSTS, newHosts);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProcessingTime() {
		return (Integer)eGet(TllPackage.Literals.COMPONENT__PROCESSING_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingTime(int newProcessingTime) {
		eSet(TllPackage.Literals.COMPONENT__PROCESSING_TIME, newProcessingTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUncertainty() {
		return (Integer)eGet(TllPackage.Literals.COMPONENT__UNCERTAINTY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUncertainty(int newUncertainty) {
		eSet(TllPackage.Literals.COMPONENT__UNCERTAINTY, newUncertainty);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ItemHistoryEntry> getHHosts() {
		return (EList<ItemHistoryEntry>)eGet(TllPackage.Literals.COMPONENT__HHOSTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void do_() {
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
			case TllPackage.COMPONENT___DO_:
				do_();
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //ComponentImpl
