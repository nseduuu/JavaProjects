// Apoio para a aula

// Classe de conexao com o banco criada
// Service da Api conectada

Model Pessoa

public class Pessoa {

    	private String nome;
    	private String cpf;
    	private int idade;
    	private String cep;

    	public String getNome() {
		return nome;
	}

    	public void setNome(String nome) {
		this.nome = nome;
	}

     	public String getCpf() {
		return cpf;
	}

    	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
    
    	public int getIdade() {
		return idade;
	}

    	public void setIdade(String idade) {
		this.idade = idade;
	}

    	public String getCep() {
		return cep;
	}

    	public void setCep(String cep) {
		this.cep = cep;
	}

}

Model endereco

public class Endereco {

    	private String cpfPessoa;
    	private String cep;
    	private String nomeRua;

    	public String getCpfPessoa() {
		return cpfPessoa;
	}

    	public void setCpf(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}

   	public String getCep() {
		return cep;
	}

    	public void setCep(String cep) {
		this.cep = cep;
	}

    	public String getNomeRua() {
		return nomeRua;
	}

    	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

}

PessoaDAO

public String inserir(Pessoa pessoa) {

		String sql = "insert into pessoa(nome, cpf, idade, cep) values (?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, professor.getNome());
			ps.setString(2, professor.getCpf());
			ps.setInt(3,  professor.getIdade());
			ps.setString(4, professor.getCep());
			if (ps.executeUpdate() > 0) {
				return "Pessoa inserida com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
  
	}

EnderecoDao

public String inserir(Endereco endereco) {

		String sql = "insert into endereco(cpfPessoa, cep, nomeRua) values (?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, endereco.getCpfPessoa());
			ps.setString(2, endereco.getCep());
			ps.setString(3, endereco.getNomeRua());
			if (ps.executeUpdate() > 0) {
				return "Endereco inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

Teste (Inserindo Primeiro pessoa depois endereço)

public class Main {
	public static void main(String[] args) {

		Connection connection = Conexao.abrirConexao(); // Conexao banco

        		Pessoa pessoa = new Pessoa();

        		pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
        		pessoa.setCpf(JOptionPane.showInputDialog("CPF:"));
        		pessoa.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade:")));
        		pessoa.setCep(JOptionPane.showInputDialog("Cep:"));

        		ApiFicService apiFicService = new ApiFicService(); // Service API

        		PessoaDAO pessoaDAO = new PessoaDAO(); 
        		String mensagemPessoa = pessoaDAO.inserir(pessoa);

        		if (mensagemPessoa.equals("Pessoa inserida com sucesso")) {

            			Endereco endereco = new Endereco();

            			endereco.setCpfPessoa(pessoa.getCpf()); 
            			endereco.setNomeRua(apiFicService.getNomeRuaPorCep(pessoa.getCep()));

            			EnderecoDAO enderecoDAO = new EnderecoDAO(); 
            			String mensagemEndereco = enderecoDAO.inserir(endereco);
            			System.out.println(mensagemEndereco);

        		} else {

            		System.out.println(mensagemPessoa);

        		}

        		Conexao.fecharConexao(); // Fechamento da conexão
    	}
}
}
