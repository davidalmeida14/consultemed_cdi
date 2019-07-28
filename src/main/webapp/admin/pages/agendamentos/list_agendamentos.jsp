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
		
		<caption>
           	<h4>
           		<c:if test="${cadastro != null}">
           			<div class="alert alert-success" role="alert">
					  ${cadastro}
					</div>
           		</c:if>
           	</h4>
           	
           	<h4>
           		<c:if test="${editado != null}">
           			<div class="alert alert-success" role="alert">
					  ${editado}
					</div>
           		</c:if>
           	</h4>
           	
           	<h4>
           		<c:if test="${remover != null}">
           			<div class="alert alert-danger" role="alert">
					  ${remover}
					</div>
           		</c:if>
           	</h4>
         </caption>
		
		
		 <div class="box box-info">
		 
            <div class="box-header with-border">
              <h3 class="box-title">Lista de Agendamentos</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body">
              <div class="table-responsive">
              	
                <table class="table no-margin">
                  <thead>
                  <tr>
                    <th>Paciente</th>
                    <th>Data Agendamento</th>
                    <th>Medico</th>
                    <th>Status da Consulta</th>
                    <th>Data Cancelamento</th>
                    <th>Ações</th>
                  </tr>
                  </thead>
					<c:forEach var="a" items="${agendamentos}">
						<tr>
							<td>${a.paciente.nome == null ? '' : a.paciente.nome}</td>
							<td>${a.dataAgendamento == null ? '' : a.dataAgendamento}</td>
							<td>${a.medico.nome == null ? '' : a.medico.nome}</td>
							<td>${a.stautsConsulta == null ? '' : a.stautsConsulta}</td>
							 <td>${a.dataCancelamento == null ? '' : a.dataCancelamento}</td>
							
								<td>
	                        		<a href="${pageContext.request.contextPath}/admin/agendamentos?id=${a.id}&action=editar" class="btn btn-sm btn-primary">Editar</a>
	                        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                        		<button value="Excluir" onclick="setaDadosModal(${a.id});" type="button" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#exampleModal">Excluir</button>                   
	                    		</td>
						</tr>
				
				</c:forEach>
                </table>
              </div>
            </div>
            <div class="box-footer clearfix">
				<a href="${pageContext.request.contextPath}/admin/agendamentos?action=novo" class="btn btn-sm btn-primary">Novo</a>&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
          </div>
          
          
        <!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Excluir Agendamento</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <strong>Deseja excluir o agendamento selecionado ?</strong>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
		        <a id="removerAgendamento" class="btn btn-danger">Deletar</a>
		      </div>
		    </div>
		  </div>
		</div>
		
		<script type="text/javascript">
		
		function setaDadosModal(valor) {
			var remove = '${pageContext.request.contextPath}/admin/agendamentos?id='+valor+'&action=delete';
		    document.getElementById('removerAgendamento').href = remove;
		}
	
	
	
	</script>
		
		
	</section>
  
	</jsp:attribute>
</mt:admin_tamplate>
