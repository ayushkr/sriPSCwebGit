/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.srisrisri.clinic.appointment;

/**
 *
 * @author akr
 */
public enum Constants {

    NOT_PAID(1),
    PENDING(2),
    PAID(3);

    private final int value;

    private Constants(int value) {
        this.value = value;
    }

}
