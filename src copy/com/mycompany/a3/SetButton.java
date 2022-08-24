package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.plaf.Border;

public class SetButton extends Button {
	
	
	 
	 ///  creates a perosnal unique color
	public SetButton(String s) {
		super(s);
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.BLUE);
		this.getAllStyles().setFgColor(ColorUtil.WHITE);
		this.getAllStyles().setPadding(2,2,2,2);
	}
}