<%@ page import="test.HibernateMenu" %>



<div class="fieldcontain ${hasErrors(bean: hibernateMenuInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="hibernateMenu.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${hibernateMenuInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: hibernateMenuInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="hibernateMenu.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" type="number" value="${hibernateMenuInstance.price}" required=""/>

</div>

