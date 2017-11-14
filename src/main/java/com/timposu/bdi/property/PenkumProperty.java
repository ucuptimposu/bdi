/*
 * Class ini digunakan untuk sebagai data binding
 * dari text ke java Date melalui web java
 */

package com.timposu.bdi.property;

import java.beans.PropertyEditorSupport;

import com.timposu.bdi.model.Penkum;
import com.timposu.bdi.service.PenkumService;

public class PenkumProperty extends PropertyEditorSupport {
	
	private PenkumService ps;
	
	public PenkumProperty(PenkumService ps) {
		this.ps = ps;
	}
	
	@Override
    public void setAsText(String text) throws IllegalArgumentException {
        Penkum p = ps.getPenkum(text);
        setValue(p);
    }

}
