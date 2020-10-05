package br.com.onparty.rwsonpartymiddleware.service.impl;

import br.com.onparty.rwsonpartymiddleware.client.RestClient;
import br.com.onparty.rwsonpartymiddleware.dto.CustomerDTO;
import br.com.onparty.rwsonpartymiddleware.dto.SupplierDTO;
import br.com.onparty.rwsonpartymiddleware.service.CustomerService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private String server = "http://rws-onparty-customer:8083/v1/customers/";

    @Override
    public List<CustomerDTO> findAll() {
        RestClient restClient = new RestClient(server);
        String json = restClient.get("");
        Gson gson = new Gson();
        List<CustomerDTO> customerDTOList = gson.fromJson(json, new TypeToken<List<CustomerDTO>>() {}.getType());
        return customerDTOList;
    }

    @Override
    public CustomerDTO findById(Integer id) {
        RestClient restClient = new RestClient(server);
        String json = restClient.get(id.toString());
        Gson gson = new Gson();
        CustomerDTO customerDTO = gson.fromJson(json, new TypeToken<CustomerDTO>() {}.getType());
        return customerDTO;
    }

    @Override
    public CustomerDTO findByCnpj(String cnpj) {
        RestClient restClient = new RestClient(server);
        String json = restClient.get("cnpj/" + cnpj);
        Gson gson = new Gson();
        CustomerDTO customerDTO = gson.fromJson(json, new TypeToken<CustomerDTO>() {}.getType());
        return customerDTO;
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        RestClient restClient = new RestClient(server);
        Gson gson = new Gson();
        String json = gson.toJson(customerDTO);
        String response = restClient.post(json);
        CustomerDTO responseDto = gson.fromJson(response, new TypeToken<CustomerDTO>() {}.getType());
        return responseDto;
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        RestClient restClient = new RestClient(server);
        Gson gson = new Gson();
        String json = gson.toJson(customerDTO);
        String response = restClient.put(json);
        CustomerDTO responseDto = gson.fromJson(response, new TypeToken<CustomerDTO>() {}.getType());
        return responseDto;
    }

    @Override
    public void delete(Integer id) {
        RestClient restClient = new RestClient(server);
        restClient.delete(id.toString());
    }
}
