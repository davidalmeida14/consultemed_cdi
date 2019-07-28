<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.com.acme.business.*"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="br.com.acme.model.*" %>
<%@page import="br.com.acme.dao.*" %>

<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_tamplate title="Dashboard">
	
	
	<jsp:attribute name="content">
	
		<section class="content">
		
		
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard">Home</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Agendamentos</li>
		  </ol>
		</nav>
		 
		<div class="box box-info">
            <div class="box-header with-border">
             
             <c:if test="${agendamento.id != null}">
					<h3 class="box-title">Editar Agendamento</h3>
	         </c:if>
	          
	          <c:if test="${agendamento.id == null}">
					<h3 class="box-title">Novo Agendamento</h3>
	         </c:if>
              
              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            
            <form role="form" method="POST" action="${pageContext.request.contextPath}/admin/agendamentos?action=novo">
              <div class="box-body">
              
              	<div class="form-group col-md-12">
					<input type="hidden" name="idAgendamento" value="${agendamento.id}" readonly="readonly" required="required" class="form-control" id="id" placeholder="Digite o nome">
				</div>
              
                <div class="form-group">
                  <label for="nome">Paciente</label>
                  <input type="text" name="nomePaciente" class="form-control" value="${agendamento.paciente.nome}" id="nome" placeholder="Informe o nome do paciente">
                </div>
                
                <div class="form-group">
                  <label for="telefonePaciente">Telefone do Paciente</label>
                  <input type="text" name="telefonePaciente" class="form-control" value="${agendamento.paciente.telefone}" id="email" placeholder="Informe o Telefone">
                </div>
                
                <div class="form-group">
                  <label for="dataAgendamento">Data Agendamento</label>
                  <input type="text" name="dataAgendamento" class="form-control" value="${agendamento.dataAgendamento}" id="telefone" placeholder="Data do Agendamento">
                </div>
                
                 <div class="form-group">
                  <label for="crm">Medico</label>
                  <input type="text" name="nomeMedico" class="form-control" value="${agendamento.medico.nome}" id="crm" placeholder="Informe o nome do médico">
                </div>
                
                <c:if test="${agendamento.dataCancelamento == null}">
	                <div class="form-group">
	                  <label for="crm">Cancelado?</label>
					  <br /><input type='checkbox' name='cancelado' value='1' />
	                </div>
	         	</c:if>
	         	
	         	<label for="statusAgendamento"> Status do Agendamento</label>
				<select name="statusAgendamento" id="instrumento">
				  <option value="agendado">AGENDANDO</option>
				  <option value="reagendado">REAGENDADO</option>
				  <option value="cancelado">CANCELADO</option>
				</select>
				
	         	<c:if test="${agendamento.dataCancelamento != null}">
	                <div class="form-group">
	                  <label for="crm">Data Cancelamento</label>
                  	  <input type="text" name="nomeMedico" class="form-control" value="${agendamento.dataCancelamento}" id="crm" placeholder="Data de cancelamento">
	                </div>
	         	</c:if>
                
              </div>

              <div class="box-footer">
					<c:if test="${medico.id != null}">
						<button type="submit" class="btn btn-warning">Editar</button>
	            	</c:if>
					
					<c:if test="${medico.id == null}">
						<button name="enviar" type="submit" class="btn btn-primary">Salvar</button>&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					<!--  <a href="${pageContext.request.contextPath}/admin/medico?action=list" class="btn btn-sm btn-default">Contatos</a>-->&nbsp;&nbsp;&nbsp;&nbsp;
              </div>
            </form>
      	</div>
			
	 </section>
  
	</jsp:attribute>
</mt:admin_tamplate>
