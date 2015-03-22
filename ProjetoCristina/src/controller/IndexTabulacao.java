package controller;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.ArrayList;

public class IndexTabulacao extends  FocusTraversalPolicy {

	   private ArrayList <Component> components = new ArrayList<Component>();

	   public void addIndexedComponent(Component componenteTela) {
	        components.add(componenteTela);
	   }

	   @Override
	   public Component getComponentAfter(Container contentPane, 
	               Component contentpane) {
	        int atIndex = components.indexOf(contentpane);
	        int nextIndex = (atIndex + 1) % components.size();
	        
	        return components.get(nextIndex);
	   }

	   @Override
	   public Component getComponentBefore(Container contentPane,
	         Component componenteTela) {
	        int atIndex = (components.indexOf(componenteTela)+1)%components.size();
	       
	        return components.get(atIndex);
	   }

	   @Override
	   public Component getFirstComponent(Container contentpane) {
	        return null;
	   }

	@Override
	public Component getLastComponent(Container contentpane) {
		// TODO Auto-generated method stub
		return components.get(components.size()-1);
	}

	@Override
	public Component getDefaultComponent(Container contentPane) {
		// TODO Auto-generated method stub
		return null;
	}
	}
