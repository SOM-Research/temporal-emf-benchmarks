/**
 */
package tll.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import tll.Area;
import tll.SimConfig;
import tll.TllPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tll.impl.SystemImpl#getArea <em>Area</em>}</li>
 *   <li>{@link tll.impl.SystemImpl#getSimconfig <em>Simconfig</em>}</li>
 *   <li>{@link tll.impl.SystemImpl#getLog <em>Log</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemImpl extends NamedElementImpl implements tll.System {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TllPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Area> getArea() {
		return (EList<Area>)eGet(TllPackage.Literals.SYSTEM__AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimConfig getSimconfig() {
		return (SimConfig)eGet(TllPackage.Literals.SYSTEM__SIMCONFIG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimconfig(SimConfig newSimconfig) {
		eSet(TllPackage.Literals.SYSTEM__SIMCONFIG, newSimconfig);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getLog() {
		return (EList<String>)eGet(TllPackage.Literals.SYSTEM__LOG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void simulate() {
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
			case TllPackage.SYSTEM___SIMULATE:
				simulate();
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //SystemImpl
