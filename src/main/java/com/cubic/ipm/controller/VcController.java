package com.cubic.ipm.controller;

import com.cubic.ipm.enums.Flags;
import com.cubic.ipm.model.Role;
import com.cubic.ipm.model.User;
import com.cubic.ipm.service.VcService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vcs"/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
class VcController {
    @Autowired
    VcService vcService;

    private Logger logger = Logger.getLogger(VcController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getActiveVCs() {
        List<User> vcList = vcService.findAll(Role.ROLE_VC);
        return ResponseEntity.ok().body(vcList);
    }

    @RequestMapping(value = "/deleted", method = RequestMethod.GET)
    public ResponseEntity getDeletedVCs() {
        List<User> vcList = vcService.findDeleted(Role.ROLE_VC, Flags.ACTIVE);
        return ResponseEntity.ok().body(vcList);
    }

    @RequestMapping(value = "/{vcId}", method = RequestMethod.GET)
    public ResponseEntity getVCs(@PathVariable long vcId) {
        User vc = vcService.find(vcId, Role.ROLE_VC);
        if (vc == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(vc);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addVC(@RequestBody User user) {
        user.setRole(Role.ROLE_VC);
        User vc = vcService.create(user);
        if (vc.getId() == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(vc);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity updateVC(@RequestBody User user) {
        user.setFlag(Flags.UPDATED);
        User vc = vcService.edit(user);
        if (vc.getId() == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.status(HttpStatus.OK).body(vc);
    }

    @RequestMapping(value = "/delete/{vcId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteVC(@PathVariable long vcId) {
        try {
            vcService.delete(vcId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @RequestMapping(value = "/enable/{vcId}", method = RequestMethod.PUT)
    public ResponseEntity enableVC(@PathVariable long vcId) {
        try {
            return ResponseEntity.ok(vcService.enable(vcId));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
