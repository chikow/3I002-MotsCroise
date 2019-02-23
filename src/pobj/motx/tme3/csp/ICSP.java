/**
 * 
 */
package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme3.IVariable;

/**
 * @author user
 *
 */
public interface ICSP {
	List<IVariable> getVars();
	boolean isConsistent();
	ICSP assign(IVariable vi, String val);
	

}
