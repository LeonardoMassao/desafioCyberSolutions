import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CyberSolutionsTest {

	WebDriver driver;

	@Before
	public void iniciar() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void encerrar() {
		try {
			Thread.sleep(4000);
		} 
		catch (InterruptedException e) {
		}
		driver.quit();
	}

	@Test
	public void MoverBarra() {
		driver.get("http://demo.automationtesting.in/Slider.html");
		Actions action = new Actions(driver);
		WebElement button = driver
				.findElement(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
		WebElement slider = driver.findElement(By.id("slider"));
		action.dragAndDrop(button, slider).build().perform();
	}

	@Test
	public void Frame() {
		driver.get("http://demo.automationtesting.in/Frames.html");
		WebElement frame = driver.findElement(By.id("singleframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.tagName("input")).sendKeys("Texto");
	}

	@Test
	public void DatePicker() {
		String dia, mes, mesValorNumerico, ano;
		dia = "20";
		mes = "January"; // Por extenso em Ingles
		mesValorNumerico = "01";
		ano = "2018";
		String nascimento = mesValorNumerico + "/" + dia + "/" + ano;
		String mesVisivel;
		String anoVisivel;

		driver.get("http://demo.automationtesting.in/Datepicker.html");
		driver.findElement(By.id("datepicker1")).click();

		do {
			WebElement monthElement = driver.findElement(By.className("ui-datepicker-month"));
			mesVisivel = monthElement.getText();
			WebElement yearElement = driver.findElement(By.className("ui-datepicker-year"));
			anoVisivel = yearElement.getText();

			if (mesVisivel.equals(mes) && anoVisivel.equals(ano)) {
				driver.findElement(By.xpath("//*[@class='ui-state-default'][.='" + dia + "']")).click();
				break;
			}

			driver.findElement(By.xpath("//*[@data-handler='prev']")).click();
		}

		while (mesVisivel != mes && anoVisivel != ano);
		driver.findElement(By.xpath("//*[@id='datepicker2']")).sendKeys(nascimento);
	}

	@Test
	public void Registro() {
		String nome = "Leonardo";
		String sobrenome = "Massao";
		String endereco = "Rua Frederico Moura, Cidade Nova - Franca\nSP";
		String email = "automationtest@cyber.com";
		String telefone = "+55(11)9857-2250";
		// Genero = Homem(Male) ou Mulher(FeMale) - Sexo Biologico
		String genero = "Male"; 
		String hobbie = "Cricket"; // Escreva "Cricket", se voce joga Criquete
		String hobbie2 = "Movies"; // Escreva "Movies", se voce passa um tempo assistindo a filmes
		String hobbie3 = ""; // Escreva "Hockey", se voce joga Hoquei
		// Linguas = Arabic, Bulgarian, Catalan, Croatin...
		String lingua1 = "Arabic";
		String lingua2 = "Bulgarian";
		// Habilidades = Analytics, Android, Java, CSS, Ruby, Python, C++...
		String habilidade = "Java"; 
		// Paises = India, Japan, Denmark, Australia, South Africa, United States of America...
		String pais = "Japan";
		String ano, mes, dia;
		ano = "2014"; // Menor que 2016, Maior que 1915
		mes = "January"; // Por extenso em Ingles
		dia = "20";
		String senha = "segredo";
		String senhaConfirmacao = "segredo";

		// Acessa o site e fecha o anuncio
		driver.get("http://demo.automationtesting.in/Register.html");
		try {
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) {
		}
		driver.findElement(By.xpath("//*[@d='M0,26 L0,6 A6,6 0 0,1 6,1 L50,1 A6,6 0 0,1 56,6 L56,20 A6,6 0 0,0 62,26 Z']")).click();
		// Dados Primarios
		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(nome);
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(sobrenome);
		driver.findElement(By.xpath("//*[@ng-model='Adress']")).sendKeys(endereco);
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys(telefone);
		driver.findElement(By.xpath("//*[@value='" + genero + "']")).click();
		// Passatempos (Hobbies)
		driver.findElement(By.xpath("//*[@value='" + hobbie + "']")).click();
		driver.findElement(By.xpath("//*[@value='" + hobbie2 + "']")).click();
		driver.findElement(By.xpath("//*[@value='" + hobbie3 + "']")).click();
		// Linguas
		driver.findElement(By.id("msdd")).click();
		String[] linguas = new String[2]; // Para adicionar mais linguas aumente o tamanho do Array e adicione a lingua no novo indice
		linguas[0] = lingua1;
		linguas[1] = lingua2;
		List<String> lista = Arrays.asList(linguas);
		for (int contador = linguas.length - 1; contador >= 0 && contador < linguas.length; contador--) {
			String lingua = lista.get(contador);
			driver.findElement(By.xpath("//*[@style='text-decoration:none'][.='" + lingua + "']")).click();
		}
		// Habilidade
		WebElement skillElement = driver.findElement(By.id("Skills"));
		Select function = new Select(skillElement);
		function.selectByVisibleText(habilidade);
		// Pais
		WebElement country = driver.findElement(By.xpath("//*[@class='select2-selection__arrow']"));
		country.click();
		driver.findElement(By.xpath("//*[@role='treeitem'][.='" + pais + "']")).click();
		// Ano Nascimento
		WebElement year = driver.findElement(By.id("yearbox"));
		Select function3 = new Select(year);
		function3.selectByVisibleText(ano);
		// Mes Nascimento
		WebElement month = driver.findElement(By.xpath("//*[@placeholder='Month']"));
		Select function4 = new Select(month);
		function4.selectByVisibleText(mes);
		// Dia Nascimento
		WebElement day = driver.findElement(By.id("daybox"));
		Select function5 = new Select(day);
		function5.selectByVisibleText(dia);
		// Senha
		driver.findElement(By.id("firstpassword")).sendKeys(senha);
		driver.findElement(By.id("secondpassword")).sendKeys(senhaConfirmacao);
	}
}
