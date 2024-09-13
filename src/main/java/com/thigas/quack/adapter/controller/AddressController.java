package com.thigas.quack.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.application.service.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO addressDTO) {
        AddressDTO createdAddress = addressService.create(addressDTO);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getById(@PathVariable Integer id) {
        return addressService.getById(id)
                .map(addressDTO -> new ResponseEntity<>(addressDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<AddressDTO>> getAll() {
        Iterable<AddressDTO> addresses = addressService.getAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody AddressDTO addressDTO) {
        if (id.equals(addressDTO.getId())) {
            addressService.update(addressDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        addressService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
