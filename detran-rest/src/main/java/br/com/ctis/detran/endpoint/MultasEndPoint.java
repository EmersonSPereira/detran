package br.com.ctis.detran.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.ctis.detran.dto.multa.MultaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("multas")
@Tag(name = "Multas", description = "Recursos para realizar operaçõs com Multas")
public interface MultasEndPoint {

	@GET
	@Path("{placaVeiculo}")
	@Produces("application/json")
	@Operation(description = "Recupera Multas pela placa", summary = "Recuperar Multas", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response consultarMultasPorPlaca(@PathParam(value = "placaVeiculo") String placa);
	

	@POST
	@Path("{placaVeiculo}")
	@Consumes("application/json")
	@Produces("application/json")
	@Operation(description = "Recurso para aplicar uma multa em um veículo", summary = "Multar um veículo", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response cadastrar(
			@PathParam(value = "placaVeiculo") String placa,
			@RequestBody(description = "Enum do tipo de Multa que será aplicada", required = true, content = @Content(schema = @Schema(implementation = MultaDTO.class)))  MultaDTO multaDTO);

	@DELETE
	@Path("{id}")
	@Produces("application/json")
	@Operation(description = "Deletar uma multa pelo id", summary = "Deletar multa ", 
			   responses = {
					   @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
					   @ApiResponse(responseCode = "400", description = "Bad Request"),
					   @ApiResponse(responseCode = "404", description = "Not found"),
					   @ApiResponse(responseCode = "500", description = "Internal Server Error") 
			    }
			  )
	Response deletarMultaPorId(@PathParam(value="id") Long id);
}
