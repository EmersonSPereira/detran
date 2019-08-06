package br.com.ctis.detran.endpoint;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.ctis.detran.dto.proprietario.ProprietarioDTO;
import br.com.ctis.detran.dto.veiculo.CadastrarVeiculoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("proprietario")
@Tag(name = "Proprietario", description = "Recursos para realizar operaçõs com Proprietario")
public interface ProprietarioEndPoint {

	@GET
	@Path("{cpfCnpj}")
	@Produces("application/json")
	@Operation(description = "Recupera o Proprietario pelo cpfCnpj", summary = "Recuperar Proprietario", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response consultarProprietarioPorCpfCnpj(@PathParam(value = "cpfCnpj") String cpfCnpj);

	@GET
	@Path("{cpfCnpj}/multas")
	@Produces("application/json")
	@Operation(description = "Recupera Multas pela cpfCnpj do proprietário", summary = "Recuperar Multas", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response consultarMultasPorCpfCnpj(@PathParam(value = "cpfCnpj") String CpfCnpj);

	@PUT
	@Path("{id}")
	@Consumes("application/json")
	@Produces("application/json")
	@Operation(description = "Edita o Proprietario ", summary = "Editar Proprietário", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response editarProprietario(@PathParam(value = "id") Long id,
			@RequestBody(description = "Dto com as indormações a serem editadas", required = true, content = @Content(schema = @Schema(implementation = ProprietarioDTO.class))) @Valid ProprietarioDTO proprietarioDTO);

}
