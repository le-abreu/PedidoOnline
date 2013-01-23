/*
	CRIR - Checkbox & Radio Input Replacement
	Author: Chris Erwin (me[at]chriserwin.com)
	www.chriserwin.com/scripts/crir/

	Updated July 27, 2006.
	Jesse Gavin added the AddEvent function to initialize
	the script. He also converted the script to JSON format.
	
	Updated July 30, 2006.
	Added the ability to tab to elements and use the spacebar
	to check the input element. This bit of functionality was
	based on a tip from Adam Burmister.
*/

crir = {
	init: function() {
		arrLabels = document.getElementsByTagName('label');
	
		searchLabels:
		for (var i=0; i<arrLabels.length; i++) {			
			// get the input element based on the for attribute of the label tag
			if (arrLabels[i].getAttributeNode('for') && arrLabels[i].getAttributeNode('for').value != '') {
				labelElementFor = arrLabels[i].getAttributeNode('for').value;				
				inputElement = document.getElementById(labelElementFor);
			}
			else {				
				continue searchLabels;
			}	
							
			inputElementClass = inputElement.className;	
		
			// if the input is specified to be hidden intiate it
			if (inputElementClass == 'checkboxGreen') {
				inputElement.className = 'crirHidden';
				
				inputElementType = inputElement.getAttributeNode('type').value;	
				
				// add the appropriate event listener to the input element
				if (inputElementType == "checkbox") {
					inputElement.onclick = crir.toggleCheckboxLabel;
				}
				else {
					inputElement.onclick = crir.toggleRadioLabel;
				}
				
				// set the initial label state
				if (inputElement.checked) {
					if (inputElementType == 'checkbox') { arrLabels[i].className = 'checkbox_green_checked'}
					else { arrLabels[i].className = 'radio_green_checked' }
				}
				else {
					if (inputElementType == 'checkbox') { arrLabels[i].className = 'checkbox_green_unchecked'}
					else { arrLabels[i].className = 'radio_green_unchecked' }
				}
			}
			else if (inputElementClass == 'checkboxRed') {
				inputElement.className = 'crirHidden';
				
				inputElementType = inputElement.getAttributeNode('type').value;	
				
				// add the appropriate event listener to the input element
				if (inputElementType == "checkbox") {
					inputElement.onclick = crir.toggleCheckboxLabel;
				}
				else {
					inputElement.onclick = crir.toggleRadioLabel;
				}
				
				// set the initial label state
				if (inputElement.checked) {
					if (inputElementType == 'checkbox') { arrLabels[i].className = 'checkbox_red_checked'}
					else { arrLabels[i].className = 'radio_red_checked' }
				}
				else {
					if (inputElementType == 'checkbox') { arrLabels[i].className = 'checkbox_red_unchecked'}
					else { arrLabels[i].className = 'radio_red_unchecked' }
				}
			}
			else if (inputElementClass == 'checkboxYellow') {
				inputElement.className = 'crirHidden';
				
				inputElementType = inputElement.getAttributeNode('type').value;	
				
				// add the appropriate event listener to the input element
				if (inputElementType == "checkbox") {
					inputElement.onclick = crir.toggleCheckboxLabel;
				}
				else {
					inputElement.onclick = crir.toggleRadioLabel;
				}
				
				// set the initial label state
				if (inputElement.checked) {
					if (inputElementType == 'checkbox') { arrLabels[i].className = 'checkbox_yellow_checked'}
					else { arrLabels[i].className = 'radio_yellow_checked' }
				}
				else {
					if (inputElementType == 'checkbox') { arrLabels[i].className = 'checkbox_yellow_unchecked'}
					else { arrLabels[i].className = 'radio_yellow_unchecked' }
				}
			}
			else if (inputElementClass == 'checkboxWhite') {
				inputElement.className = 'crirHidden';
				
				inputElementType = inputElement.getAttributeNode('type').value;	
				
				// add the appropriate event listener to the input element
				if (inputElementType == "checkbox") {
					inputElement.onclick = crir.toggleCheckboxLabel;
				}
				else {
					inputElement.onclick = crir.toggleRadioLabel;
				}
				
				// set the initial label state
				if (inputElement.checked) {
					if (inputElementType == 'checkbox') { arrLabels[i].className = 'checkbox_white_checked'}
					else { arrLabels[i].className = 'radio_white_checked' }
				}
				else {
					if (inputElementType == 'checkbox') { arrLabels[i].className = 'checkbox_white_unchecked'}
					else { arrLabels[i].className = 'radio_white_unchecked' }
				}
			}
			else if (inputElementClass == 'checkboxBlue') {
				inputElement.className = 'crirHidden';
				
				inputElementType = inputElement.getAttributeNode('type').value;	
				
				// add the appropriate event listener to the input element
				if (inputElementType == "checkbox") {
					inputElement.onclick = crir.toggleCheckboxLabel;
				}
				else {
					inputElement.onclick = crir.toggleRadioLabel;
				}
				
				// set the initial label state
				if (inputElement.checked) {
					if (inputElementType == 'checkbox') { arrLabels[i].className = 'checkbox_blue_checked'}
					else { arrLabels[i].className = 'radio_blue_checked' }
				}
				else {
					if (inputElementType == 'checkbox') { arrLabels[i].className = 'checkbox_blue_unchecked'}
					else { arrLabels[i].className = 'radio_blue_unchecked' }
				}
			}
			else if (inputElement.nodeName != 'SELECT' && inputElement.getAttributeNode('type').value == 'radio') { // this so even if a radio is not hidden but belongs to a group of hidden radios it will still work.
				arrLabels[i].onclick = crir.toggleRadioLabel;
				inputElement.onclick = crir.toggleRadioLabel;
			}
		}			
	},	
	
	findLabel: function (inputElementID) {
		arrLabels = document.getElementsByTagName('label');
	
		searchLoop:
		for (var i=0; i<arrLabels.length; i++) {
			if (arrLabels[i].getAttributeNode('for') && arrLabels[i].getAttributeNode('for').value == inputElementID) {				
				return arrLabels[i];
				break searchLoop;				
			}
		}		
	},	
	
	toggleCheckboxLabel: function () {
		labelElement = crir.findLabel(this.getAttributeNode('id').value);
	
		if(labelElement.className == 'checkbox_green_checked') {
			labelElement.className = "checkbox_green_unchecked";
		}
		else if(labelElement.className == 'checkbox_green_unchecked'){
			labelElement.className = "checkbox_green_checked";
		}
		else if(labelElement.className == 'checkbox_red_checked') {
			labelElement.className = "checkbox_red_unchecked";
		}
		else if(labelElement.className == 'checkbox_red_unchecked'){
			labelElement.className = "checkbox_red_checked";
		}
		else if(labelElement.className == 'checkbox_white_checked') {
			labelElement.className = "checkbox_white_unchecked";
		}
		else if(labelElement.className == 'checkbox_white_unchecked'){
			labelElement.className = "checkbox_white_checked";
		}
		else if(labelElement.className == 'checkbox_yellow_checked') {
			labelElement.className = "checkbox_yellow_unchecked";
		}
		else if(labelElement.className == 'checkbox_yellow_unchecked'){
			labelElement.className = "checkbox_yellow_checked";
		}
		else if(labelElement.className == 'checkbox_blue_checked') {
			labelElement.className = "checkbox_blue_unchecked";
		}
		else if(labelElement.className == 'checkbox_blue_unchecked'){
			labelElement.className = "checkbox_blue_checked";
		}
	},	
	
	toggleRadioLabel: function () {			 
		clickedLabelElement = crir.findLabel(this.getAttributeNode('id').value);
		
		clickedInputElement = this;
		clickedInputElementName = clickedInputElement.getAttributeNode('name').value;
		
		arrInputs = document.getElementsByTagName('input');
	
		// uncheck (label class) all radios in the same group
		for (var i=0; i<arrInputs.length; i++) {			
			inputElementType = arrInputs[i].getAttributeNode('type').value;
			if (inputElementType == 'radio') {
				inputElementName = arrInputs[i].getAttributeNode('name').value;
				inputElementClass = arrInputs[i].className;
				// find radio buttons with the same 'name' as the one we've changed and have a class of chkHidden
				// and then set them to unchecked
				if (inputElementName == clickedInputElementName && inputElementClass == 'crirHidden') {				
					inputElementID = arrInputs[i].getAttributeNode('id').value;
					labelElement = crir.findLabel(inputElementID);
					labelElement.className = 'radio_unchecked';
				}
			}
		}
	
		// if the radio clicked is hidden set the label to checked
		if (clickedInputElement.className == 'crirHidden') {
			clickedLabelElement.className = 'radio_checked';
		}
	},
	
	addEvent: function(element, eventType, doFunction, useCapture){
		if (element.addEventListener) 
		{
			element.addEventListener(eventType, doFunction, useCapture);
			return true;
		} else if (element.attachEvent) {
			var r = element.attachEvent('on' + eventType, doFunction);
			return r;
		} else {
			element['on' + eventType] = doFunction;
		}
	}
}

crir.addEvent(window, 'load', crir.init, false);