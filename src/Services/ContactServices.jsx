import axios from "axios";

export class ContactServices{
    static serverURl=`http://localhost:8080`;
    static getAllContacts(){
        // let dataUrl= `${this.serverURl}/contacts`
        return axios.get(`http://localhost:8080/contacts`)
    }

    static getContact(contactId){
        // let dataUrl= `${this.serverURl}/contacts/${contactId}`
        return axios.get(`http://localhost:8080/contact/${contactId}`)
    }

    static createContact(contact){
        // let dataURL=`${this.serverURl}/contacts`;
        return axios.post(`http://localhost:8080/contact`,contact)
    }

    static updateContact(contact,contactId){
        // let dataURL=`${this.serverURl}/contacts/${contactId}`;
        return axios.put(`http://localhost:8080/contact`,contact)
    }

    static deleteContact(contactId){
        // let dataUrl= `${this.serverURl}/contacts/${contactId}`;
        return axios.delete(`http://localhost:8080/contact/${contactId}`)
    }
}