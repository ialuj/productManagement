package com.cayena.api.productManagement.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cayena.api.productManagement.dto.SupplierDTO;
import com.cayena.api.productManagement.exception.BusinessException;
import com.cayena.api.productManagement.model.entity.Supplier;
import com.cayena.api.productManagement.model.service.ISupplierQueryService;

/**
 * 
 * @author Jose Julai Ritsure
 *
 *         Interface that implements query suppliers endpoints
 *
 */

@RestController
@RequestMapping("api/v1/suppliers")
@CrossOrigin(origins = {"*"})
public class SupplierQueryServiceWsImpl implements ISupplierQueryServiceWs {

	@Autowired
	private ISupplierQueryService supplierQueryService;

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<SupplierDTO> getSupplierById(Long id) {

		try {
			final Supplier supplier = supplierQueryService.getSupplierById(id);

			final SupplierDTO dto = new SupplierDTO(supplier);

			final ResponseEntity<SupplierDTO> response = ResponseEntity.ok(dto);

			return response;

		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@Override
	@GetMapping("/{name}")
	public ResponseEntity<SupplierDTO> getSupplierByName(String name) {
		try {
			final Supplier supplier = supplierQueryService.getSupplierByName(name);

			if (supplier == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}

			final SupplierDTO dto = new SupplierDTO(supplier);

			final ResponseEntity<SupplierDTO> response = ResponseEntity.ok(dto);

			return response;

		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@Override
	@GetMapping
	public ResponseEntity<List<SupplierDTO>> listAllSuppliers() {
		try {
			final List<Supplier> suppliers = supplierQueryService.listAllSuppliers();

			final List<SupplierDTO> dtos = suppliers.stream().map(SupplierDTO::new).collect(Collectors.toList());

			final ResponseEntity<List<SupplierDTO>> response = ResponseEntity.ok(dtos);

			return response;

		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

}
