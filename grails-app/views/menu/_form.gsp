<%@ page import="test.Menu" %>



<div class="fieldcontain ${hasErrors(bean: menuInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="menu.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${menuInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: menuInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="menu.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" type="number" value="${menuInstance.price}" required=""/>

</div>

