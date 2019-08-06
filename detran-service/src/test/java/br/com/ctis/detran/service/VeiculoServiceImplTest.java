package br.com.ctis.detran.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.ctis.detran.dto.veiculo.CadastrarVeiculoDTO;
import br.com.ctis.detran.exception.DAOException;
import br.com.ctis.detran.exception.NegocioException;
import br.com.ctis.detran.exception.RegistroNaoEncontradoException;
import br.com.ctis.detran.persistence.dao.VeiculoDAO;
import br.com.ctis.detran.persistence.model.Proprietario;
import br.com.ctis.detran.persistence.model.Veiculo;
import br.com.ctis.detran.service.impl.VeiculoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class VeiculoServiceImplTest {

	@Mock
	private VeiculoDAO veiculoDAO;

	@Mock
	private ProprietarioService proprietarioService;

	private VeiculoServiceImpl veiculoServiceImpl;

	@Before
	public void init() {

		veiculoServiceImpl = new VeiculoServiceImpl();
		veiculoServiceImpl.setProprietarioService(proprietarioService);
		veiculoServiceImpl.setVeiculoDAO(veiculoDAO);

	}

	@Test
	public void cadastrarVeiculoTest() throws RegistroNaoEncontradoException, DAOException {

		Mockito.when(proprietarioService.consultarPorId(Matchers.anyLong())).thenReturn(mockProprietario());
		Mockito.when(veiculoDAO.buscarVeiculoPorPlaca(Matchers.anyString())).thenThrow(new NegocioException());

		this.veiculoServiceImpl.cadastrarVeiculo(mockveiculoDTO());
	}

	@Test
	public void cadastrarVeiculoFluxoAlternativoTest() throws RegistroNaoEncontradoException, DAOException {

		Mockito.when(proprietarioService.consultarPorId(Matchers.anyLong())).thenReturn(new Proprietario());
		Mockito.when(veiculoDAO.buscarVeiculoPorPlaca(Matchers.anyString())).thenThrow(new NegocioException());

		this.veiculoServiceImpl.cadastrarVeiculo(mockveiculoDTO());
	}

	@Test
	public void buscarVeiculoPorPlacaTest() throws RegistroNaoEncontradoException, DAOException {

		Mockito.when(veiculoDAO.buscarVeiculoPorPlaca(Matchers.anyString())).thenReturn(new Veiculo());
		assertNotNull(veiculoServiceImpl.buscarVeiculoPorPlaca(Matchers.anyString()));
	}

	@Test(expected = NegocioException.class)
	public void buscarVeiculoPorPlacaRegistroNaoEncontradoExceptionTest()
			throws RegistroNaoEncontradoException, DAOException {

		Mockito.when(veiculoDAO.buscarVeiculoPorPlaca(Matchers.anyString()))
				.thenThrow(new RegistroNaoEncontradoException());
		assertNotNull(veiculoServiceImpl.buscarVeiculoPorPlaca(Matchers.anyString()));
	}

	@Test(expected = NegocioException.class)
	public void buscarVeiculoPorPlacaDAOExceptionTest() throws RegistroNaoEncontradoException, DAOException {

		Mockito.when(veiculoDAO.buscarVeiculoPorPlaca(Matchers.anyString())).thenThrow(new DAOException());
		assertNotNull(veiculoServiceImpl.buscarVeiculoPorPlaca(Matchers.anyString()));
	}

	@Test
	public void buscarVeiculoPorCpfCnpjProprietarioTest() throws RegistroNaoEncontradoException, DAOException {

		Mockito.when(veiculoDAO.buscarVeiculoPorCpfCnpjProprietario(Matchers.anyString()))
				.thenReturn(new ArrayList<Veiculo>());
		assertNotNull(veiculoServiceImpl.buscarVeiculoPorCpfCnpjProprietario(Matchers.anyString()));
	}

	@Test(expected = NegocioException.class)
	public void buscarVeiculoPorCpfCnpjProprietarioRegistroNaoEncontradoExceptionTest()
			throws RegistroNaoEncontradoException, DAOException {

		Mockito.when(veiculoDAO.buscarVeiculoPorCpfCnpjProprietario(Matchers.anyString()))
				.thenThrow(new RegistroNaoEncontradoException());
		assertNotNull(veiculoServiceImpl.buscarVeiculoPorCpfCnpjProprietario(Matchers.anyString()));
	}
	
	@Test(expected = NegocioException.class)
	public void buscarVeiculoPorCpfCnpjProprietarioDAOExceptionTest()
			throws RegistroNaoEncontradoException, DAOException {

		Mockito.when(veiculoDAO.buscarVeiculoPorCpfCnpjProprietario(Matchers.anyString()))
				.thenThrow(new DAOException());
		assertNotNull(veiculoServiceImpl.buscarVeiculoPorCpfCnpjProprietario(Matchers.anyString()));
	}


	private CadastrarVeiculoDTO mockveiculoDTO() {

		CadastrarVeiculoDTO cadastrarVeiculoDTO = new CadastrarVeiculoDTO();
		cadastrarVeiculoDTO.setNome("nome");
		cadastrarVeiculoDTO.setCor("cor");
		cadastrarVeiculoDTO.setMarca("marca");
		cadastrarVeiculoDTO.setAno(1999);
		cadastrarVeiculoDTO.setProprietario(mockProprietario());
		cadastrarVeiculoDTO.setRenavan("renavan");
		return cadastrarVeiculoDTO;
	}

	private Proprietario mockProprietario() {

		Proprietario proprietario = new Proprietario();
		proprietario.setNome("nome");
		proprietario.setId(1l);
		return proprietario;
	}

}
