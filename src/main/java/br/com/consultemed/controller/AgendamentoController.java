package br.com.consultemed.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.Medico;
import br.com.consultemed.model.Paciente;
import br.com.consultemed.model.StatusConsulta;
import br.com.consultemed.service.AgendamentoService;
import br.com.consultemed.service.MedicoBusiness;
import br.com.consultemed.utils.Constantes;

@WebServlet("/admin/agendamentos")
public class AgendamentoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String action = request.getParameter(Constantes.ACTION);

		try {
			switch (action) {
			case Constantes.NOVO:
				novo(request, response);
				break;
			case Constantes.DELETE:
				delete(request, response);
				break;
			case Constantes.EDITAR:
				editar(request, response);
				break;
			case Constantes.LISTAR :
				list(request, response);
				break;
			default:
				notfound(request, response);
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void notfound(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AgendamentoService agendamento = new AgendamentoService();
		List<Agendamento> agendamentos = agendamento.listar();
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.AGENDAMENTOS);
		request.setAttribute("agendamentos", agendamentos);
		rd.forward(request, response);
		
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AgendamentoService service = new AgendamentoService();
		Agendamento agendamento = service.buscaPorId(Long.parseLong(request.getParameter("id")));
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_AGENDAMENTOS);
		request.setAttribute("agendamento",agendamento);
		rd.forward(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AgendamentoService services = new AgendamentoService();
		services.remover(Long.parseLong(request.getParameter("id")));
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.AGENDAMENTOS);
		rd.forward(request, response);
	}

	private void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_AGENDAMENTOS);
		rd.forward(request, response);
		
	}

	@SuppressWarnings("null")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeMedico = request.getParameter("nomeMedico");
		String dtAgendamento = request.getParameter("dataAgendamento");
		String nomePaciente = request.getParameter("nomePaciente");
		String telefonePaciente = request.getParameter("telefonePaciente");
		String cpfPaciente = request.getParameter("cpfPaciente");
		String idAgendamento = request.getParameter("idAgendamento");
		String cancelado = request.getParameter("cancelado");
		String statusAgendamento = request.getParameter("statusAgendamento");
		
		if(Objects.isNull(idAgendamento)) {
			idAgendamento = "";
		}
		if(Objects.isNull(cancelado)) {
			cancelado = "";
		}
		Medico medico;
		
		Paciente paciente = new Paciente();
		MedicoBusiness md = new MedicoBusiness();
		
		medico = md.buscaPorNome(nomeMedico);
		
		if(medico.getNome() == null) {
			medico = new Medico();
			medico.setNome("Nome");
			medico.setCrm("000");
			md.salvar(medico);
			medico = md.buscaPorNome(nomeMedico);
		}
		
		medico.setId(medico.getId());
		paciente.setId(1L);
//		paciente.setNome(nomePaciente);
//		paciente.setTelefone(telefonePaciente);
//		paciente.setCpf(cpfPaciente);
		
		LocalDate dataAgendamento = LocalDate.parse(dtAgendamento);
		LocalDateTime time = dataAgendamento.atTime(12, 00);
		Agendamento a = new Agendamento();
		
		a.setDataAgendamento(time);
		a.setMedico(medico);
		a.setPaciente(paciente);
		a.setStautsConsulta(StatusConsulta.AGENDADO);
		
		if("1".equals(cancelado)) {
			a.setDataCancelamento(LocalDateTime.now());
			a.setStautsConsulta(StatusConsulta.CANCELADO);
		}
		
		if(idAgendamento != "") {
			a.setId(Long.parseLong(idAgendamento));
			AgendamentoService agendamento = new AgendamentoService();
			agendamento.editar(a);
			request.setAttribute("editado", Constantes.AGENDAMENTO + " " + "para o paciente: " + nomePaciente + Constantes.AGENDAMENTO_EDITADO);
			list(request, response);
		} else {
			AgendamentoService agendamento = new AgendamentoService();
			agendamento.salvar(a);
			request.setAttribute("cadastro", Constantes.AGENDAMENTO + " para o paciente: "+ nomePaciente + Constantes.AGENDAMENTO_SUCESSO);
			list(request, response);
		}
		
		try{
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
