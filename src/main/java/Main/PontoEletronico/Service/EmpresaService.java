package Main.PontoEletronico.Service;

import Main.PontoEletronico.DTO.CadastroEmpresaDTO;
import Main.PontoEletronico.Model.Empresa;
import Main.PontoEletronico.Repository.EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Empresa cadastroEmpresa(CadastroEmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa();
        empresa.setName(empresaDTO.name());
        empresa.setEmail(empresaDTO.email());
        empresa.setCnpj(empresaDTO.cnpj());
        empresa.setTelefone(empresaDTO.telefone());
        empresa.setPassword(passwordEncoder.encode(empresaDTO.password()));

        return repository.save(empresa);
    }

    public List<Empresa> listaEmpresas() {
        return repository.findAll();
    }

    public Optional<Empresa> empresaById(Long id) {
        Optional<Empresa> empresa = repository.findById(id);
        if (empresa.isEmpty()) {
            throw new EntityNotFoundException("Empresa não encontrada!");
        }
        return empresa;
    }

    public Optional<Empresa> atualizacaoEmpresa(Long id, CadastroEmpresaDTO empresaDTO) {
        Optional<Empresa> empresa = repository.findById(id);
        if (empresa.isEmpty()) {
            throw new EntityNotFoundException("Empresa não encontrada!");
        }

        Empresa empresaAtt = empresa.get();
        empresaAtt.setName(empresaDTO.name());
        empresaAtt.setEmail(empresaDTO.email());
        empresaAtt.setCnpj(empresaDTO.cnpj());
        empresaAtt.setTelefone(empresaDTO.telefone());

        return Optional.of(repository.save(empresaAtt));
    }

    public void deletarEmpresa(Long id) {
        Optional<Empresa> empresa = repository.findById(id);
        if (empresa.isEmpty()) {
            throw new EntityNotFoundException("Empresa não encontrada com esse id");
        }
        repository.delete(empresa.get());
    }
}