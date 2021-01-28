package business

import entity.ContatoEntity
import repositorio.ContactRepositorio

class ContactBusiness() {

    fun validate(name: String, fone: String) {
        if (name == "") {
            throw Exception("nome é obrigatório")
        }
        if (fone == "")
            throw Exception("telefone é obrigatório")
    }

    fun validateDelete(name: String, fone: String) {
        if (name == "" || fone == "")
            throw Exception("É necessario selecionar um contato antes de remover")

    }

    fun save(name: String, fone: String) {
        validate(name, fone)

        val contact = ContatoEntity(name, fone)
        ContactRepositorio.save(contact)
    }

    fun delete(name: String, fone: String) {
        validateDelete(name, fone)

        val contact = ContatoEntity(name, fone)
        ContactRepositorio.delete(contact)


    }
}