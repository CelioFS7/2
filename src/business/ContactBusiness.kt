package business

import entity.ContatoEntity
import repositorio.ContactRepositorio

class ContactBusiness() {

        private fun validate(name: String, fone: String) {
        if (name == "") {
            throw Exception("nome é obrigatório")
        }
        if (fone == "")
            throw Exception("telefone é obrigatório")
    }

    private fun validateDelete(name: String, fone: String) {
        if (name == "" || fone == "")
            throw Exception("É necessario selecionar um contato antes de remover")

    }

   fun getContactCountDescription(): String {
       val list = getList()
       return when{
           list.isEmpty() ->"0 Contatos"
           list.size == 1 ->"1 Contato"
           else ->"${list.size} contatos"
       }


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

    fun getList(): List<ContatoEntity> {

            return ContactRepositorio.getList()

    }
}